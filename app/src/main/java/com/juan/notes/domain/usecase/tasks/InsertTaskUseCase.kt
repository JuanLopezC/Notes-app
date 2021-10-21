package com.juan.notes.domain.usecase.tasks

import com.juan.notes.data.models.Task
import com.juan.notes.data.repository.task.TaskRepository
import javax.inject.Inject

class InsertTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task) = taskRepository.insertTask(task)
}