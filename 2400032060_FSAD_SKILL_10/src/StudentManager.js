import React, { useState } from "react";
import "./App.css";

function StudentManager() {

  const [students, setStudents] = useState([
    { id: 1, name: "Manvith", course: "CSE" },
    { id: 2, name: "Sai", course: "IT" },
    { id: 3, name: "Ravi", course: "ECE" },
    { id: 4, name: "Kiran", course: "MECH" },
    { id: 5, name: "Anu", course: "CIVIL" }
  ]);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  const handleChange = (e) => {
    setNewStudent({
      ...newStudent,
      [e.target.name]: e.target.value
    });
  };

  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) {
      alert("Enter all fields");
      return;
    }

    setStudents([...students, newStudent]);
    setNewStudent({ id: "", name: "", course: "" });
  };

  const deleteStudent = (id) => {
    setStudents(students.filter((s) => s.id !== id));
  };

  return (
    <div className="container">

      <h2>Student Manager</h2>

      <input type="number" name="id" placeholder="ID"
        value={newStudent.id} onChange={handleChange} />

      <input type="text" name="name" placeholder="Name"
        value={newStudent.name} onChange={handleChange} />

      <input type="text" name="course" placeholder="Course"
        value={newStudent.course} onChange={handleChange} />

      <button onClick={addStudent}>Add Student</button>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.course}</td>
                <td>
                  <button onClick={() => deleteStudent(s.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}

    </div>
  );
}

export default StudentManager;