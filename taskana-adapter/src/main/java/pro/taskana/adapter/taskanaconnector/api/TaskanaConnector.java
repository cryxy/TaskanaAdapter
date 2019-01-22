package pro.taskana.adapter.taskanaconnector.api;

import java.time.Instant;
import java.util.List;

import pro.taskana.Task;
import pro.taskana.adapter.exceptions.TaskConversionFailedException;
import pro.taskana.adapter.exceptions.TaskCreationFailedException;
import pro.taskana.adapter.systemconnector.api.GeneralTask;

/**
 * The interface that must be implemented by a SystemConnector to a taskana system.
 * @author bbr
 *
 */
public interface TaskanaConnector {
    /**
     * retrieve completed taskana tasks.
     * @param completedAfter  The instant after which the tasks have been completed.
     * @return
     */
    List<GeneralTask> retrieveCompletedTaskanaTasks(Instant completedAfter);

    /**
     * create a task in taskana on behalf of an external task.
     * @param taskanaTask                   The taskana task to be created.
     * @throws TaskCreationFailedExceptioin if the attempt to create a taskana task failed.
     */
    void createTaskanaTask(Task taskanaTask) throws TaskCreationFailedException;

    /**
     * Convert a general task to a Taskana task.
     * @param generalTask   the general task that is to be converted.
     * @return              the taskana task that will be created started on behalf of the general task.
     */
    Task convertToTaskanaTask(GeneralTask generalTask) throws TaskConversionFailedException;

    /**
     * Convert a taskana task into a general task.
     * @param task  the taskana task that was executed on behalf of a general task.
     * @return      the general task for which the taskana task was executed.
     */
    GeneralTask convertToGeneralTask(Task task);

}