import axios from "axios";
import { useEffect, useState } from "react";
import "./App.css";

function StudentList({ reload }) {
  const [data, setData] = useState([]);

  const load = () => {
    axios.get("http://localhost:8081/students")
      .then(res => setData(res.data));
  };

  useEffect(() => { 
    load(); 
  }, [reload]);   // ✅ important fix

  const del = (id) => {
    axios.delete(`http://localhost:8081/students/${id}`)
      .then(() => load());
  };

  const update = (s) => {
    const name = prompt("Enter new name", s.name);
    const email = prompt("Enter new email", s.email);
    const course = prompt("Enter new course", s.course);

    axios.put(`http://localhost:8081/students/${s.id}`, {
      name, email, course
    }).then(() => load());
  };

  return (
    <div>
      <h2>Student List</h2>

      {data.map(s => (
        <div className="student-card" key={s.id}>
          <div>
            <b>{s.name}</b><br/>
            {s.email}<br/>
            {s.course}
          </div>

          <div>
            <button className="update-btn" onClick={() => update(s)}>Update</button>
            <button className="delete-btn" onClick={() => del(s.id)}>Delete</button>
          </div>
        </div>
      ))}
    </div>
  );
}

export default StudentList;