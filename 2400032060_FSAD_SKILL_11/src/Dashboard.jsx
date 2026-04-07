import { useState } from "react";
import LocalUserList from "./LocalUserList";
import UserList from "./UserList";
import FakePostList from "./FakePostList";

function Dashboard() {
  const [view, setView] = useState("");

  return (
    <div className="container">
      <h1>🚀 React API Dashboard</h1>

      <div style={{ textAlign: "center" }}>
        <button onClick={() => setView("local")}>👤 Local Users</button>
        <button onClick={() => setView("api")}>🌐 API Users</button>
        <button onClick={() => setView("fake")}>📝 Posts</button>
      </div>

      <hr />

      {view === "local" && <LocalUserList />}
      {view === "api" && <UserList />}
      {view === "fake" && <FakePostList />}
    </div>
  );
}

export default Dashboard;