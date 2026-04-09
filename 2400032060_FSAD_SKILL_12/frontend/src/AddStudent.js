import axios from "axios";
import { useState } from "react";
import "./App.css";

function AddStudent({ refresh }) {
  const [data, setData] = useState({ name:"", email:"", course:"" });

  const handle = e => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const submit = () => {
    axios.post("http://localhost:8081/students", data)
      .then(() => {
        setData({ name:"", email:"", course:"" });
        refresh();
      });
  };

  return (
    <div className="form-container">
      <h2>Add Student</h2>

      <input name="name" value={data.name} onChange={handle} placeholder="Name"/>
      <input name="email" value={data.email} onChange={handle} placeholder="Email"/>
      <input name="course" value={data.course} onChange={handle} placeholder="Course"/>

      <button className="add-btn" onClick={submit}>Add</button>
    </div>
  );
}

export default AddStudent;