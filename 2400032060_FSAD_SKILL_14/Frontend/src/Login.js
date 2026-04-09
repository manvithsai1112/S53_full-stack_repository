import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./App.css";

function Login() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleLogin = async () => {
    const res = await axios.post("http://localhost:8081/login", user);

    if (res.data) {
      localStorage.setItem("user", res.data.username);
      navigate("/home");
    } else {
      alert("Invalid credentials");
    }
  };

  return (
    <div className="box">
      <h2>Login</h2>

      <input
        placeholder="Username"
        onChange={e => setUser({ ...user, username: e.target.value })}
      />

      <input
        type="password"
        placeholder="Password"
        onChange={e => setUser({ ...user, password: e.target.value })}
      />

      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;