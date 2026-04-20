import { useState} from "react";

function App() {
  
  const [title, setTitle] = useState("");
  
  const addTask = () => {
    if(title.trim() === "") return;
    console.log("Task Added:", title); 
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