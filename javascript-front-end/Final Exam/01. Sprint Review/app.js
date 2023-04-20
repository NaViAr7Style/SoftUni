function solve(input) {
  let n = Number(input.shift());
  let taskCollection = {};

  const commandParser = {
      "Add New": addTask,
      "Change Status": changeStatus,
      "Remove Task": removeTask
  }

  for (let i = 0; i < n; i++) {
      let [assignee, taskId, title, status, estimatedPoints] = input.shift().split(":");

      if (!taskCollection.hasOwnProperty(assignee)) {
          taskCollection[assignee] = [];
      }

      let task = { taskId, title, status, estimatedPoints };
      taskCollection[assignee].push(task);
  }

  while (input.length > 0) {
      let commandTokens = input.shift().split(":");
      let command = commandTokens.shift();
      commandParser[command](...commandTokens);
  }

  let toDoTasksTotalPoints = 0;
  let inProgressTasksTotalPoints = 0;
  let codeReviewTasksTotalPoints = 0;
  let doneTasksTotalPoints = 0;

  for (const assignee in taskCollection) {
      let taskArray = taskCollection[assignee];

      for (const task of taskArray) {
          switch(task.status) {
              case "ToDo":
              toDoTasksTotalPoints += Number(task.estimatedPoints);
              break;
              case "In Progress":
              inProgressTasksTotalPoints += Number(task.estimatedPoints);
              break;
              case "Code Review":
              codeReviewTasksTotalPoints += Number(task.estimatedPoints);
              break;
              case "Done":
              doneTasksTotalPoints += Number(task.estimatedPoints);
              break;
          }
      }
  }
  
  console.log(`ToDo: ${toDoTasksTotalPoints}pts`);
  console.log(`In Progress: ${inProgressTasksTotalPoints}pts`);
  console.log(`Code Review: ${codeReviewTasksTotalPoints}pts`);
  console.log(`Done Points: ${doneTasksTotalPoints}pts`);

  if (doneTasksTotalPoints >= toDoTasksTotalPoints + inProgressTasksTotalPoints + codeReviewTasksTotalPoints) {
      console.log("Sprint was successful!");
  } else {
      console.log("Sprint was unsuccessful...");
  }
  

  function addTask(assignee, taskId, title, status, estimatedPoints) {
      if (!taskCollection.hasOwnProperty(assignee)) {
          console.log(`Assignee ${assignee} does not exist on the board!`);
          return;
      }

      let task = { taskId, title, status, estimatedPoints };
      taskCollection[assignee].push(task); 
  }

  function changeStatus(assignee, taskToUpdate, newStatus) {
      if (!taskCollection.hasOwnProperty(assignee)) {
          console.log(`Assignee ${assignee} does not exist on the board!`);
          return;
      }

      let taskExists = false;

      for (const task of taskCollection[assignee]) {
          let { taskId } = task;

          if (taskId === taskToUpdate) {
              taskExists = true;
              task.status = newStatus;
              break;
          }
      }

      if (!taskExists) {
          console.log(`Task with ID ${taskToUpdate} does not exist for ${assignee}!`);
      }
  }

  function removeTask(assignee, index) {
      if (!taskCollection.hasOwnProperty(assignee)) {
          console.log(`Assignee ${assignee} does not exist on the board!`);
          return;
      }

      let taskArray = taskCollection[assignee];

      if (index < 0 || taskArray.length <= index) {
          console.log("Index is out of range!");
          return;
      }

      taskArray.splice(index, 1);
  }
}