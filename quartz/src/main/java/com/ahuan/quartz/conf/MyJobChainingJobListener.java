/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ahuan.quartz.conf;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.listeners.JobChainingJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author huan
 * @date 2019/10/28
 */
public class MyJobChainingJobListener extends JobChainingJobListener {
    private Logger logger = LoggerFactory.getLogger(MyJobChainingJobListener.class);

    private String name;
    private Map<JobKey, JobKey> chainLinks;

    public MyJobChainingJobListener(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void addJobChainLink(JobKey firstJob, JobKey secondJob) {

        if (firstJob == null || secondJob == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }

        if (firstJob.getName() == null || secondJob.getName() == null) {
            throw new IllegalArgumentException("Key cannot have a null name!");
        }

        chainLinks.put(firstJob, secondJob);
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

        JobKey sj = chainLinks.get(context.getJobDetail().getKey());

        if (sj == null) {
            return;
        }

        logger.info("Job '" + context.getJobDetail().getKey() + "' will now chain to Job '" + sj + "'");

        try {
            context.getScheduler().triggerJob(sj);
        } catch (SchedulerException se) {
            logger.error("Error encountered during chaining to Job '" + sj + "'", se);
        }
    }
}
