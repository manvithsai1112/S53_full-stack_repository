import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function Profile() {
  const [user, setUser] = useState({});

  useEffect(() => {
    const username = localStorage.getItem("user");

    axios
      .get(`http://localhost:8081/user/${username}`)
      .then(res => setUser(res.data));
  }, []);

  return (
    <div className="box">
      <h2>Profile</h2>
      <p><b>Username:</b> {user.username}</p>
    </div>
  );
}

export default Profile;