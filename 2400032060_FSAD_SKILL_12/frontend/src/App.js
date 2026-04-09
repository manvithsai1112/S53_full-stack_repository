import { useState } from "react";
import StudentList from "./StudentList";
import AddStudent from "./AddStudent";
import "./App.css";

function App() {
  const [reload, setReload] = useState(false);

  const refresh = () => setReload(!reload);

  return (
    <div>
      <h1>Student Management System</h1>
      <AddStudent refresh={refresh} />
      <StudentList reload={reload} />
    </div>
  );
}

export default App;