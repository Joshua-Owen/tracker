import { useState} from "react";

function App() {
  
  const [title, setTitle] = useState("");
  
  const addTask = async () => {
    if(title.trim() === "") return;
    
    //console.log("Task Added:", title); 
    //setTitle("");

    //sent JSON data in the form of a JSON string to backend
    const response = await fetch("http://localhost:8080/tasks", {
        method: "POST",
        headers: {"Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: title,
        completed: false,
      }),
    });
    //convert the server response back to JavaScript
    const data = await response.json();

    console.log("saved task", data);

    setTitle("");
  }
  return(
    <div>
      <h1>DevTrackr Task Manager</h1>
      <input 
        id="taskTitle"
        name="taskTitle"
        type="text"
        placeholder="Enter task"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <button onClick = {addTask} >Add Task</button>
      <p> You typed: {title} </p>
    </div>
  );
}

export default App;