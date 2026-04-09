import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./App.css";

function Register() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleSubmit = async () => {
    await axios.post("http://localhost:8081/register", user);
    alert("Registered Successfully");
    navigate("/login");
  };

  return (
    <div className="box">
      <h2>Register</h2>

      <input
        placeholder="Username"
        onChange={e => setUser({ ...user, username: e.target.value })}
      />

      <input
        type="password"
        placeholder="Password"
        onChange={e => setUser({ ...user, password: e.target.value })}
      />

      <button onClick={handleSubmit}>Register</button>
    </div>
  );
}

export default Register;