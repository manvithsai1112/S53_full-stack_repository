import { useEffect, useState } from "react";
import axios from "axios";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [userId, setUserId] = useState("");

  const fetchPosts = async () => {
    try {
      const res = await axios.get("https://dummyjson.com/posts");
      setPosts(res.data.posts);
      setFiltered(res.data.posts);
    } catch (error) {
      console.log("Error:", error);
    }
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  const handleFilter = (e) => {
    const value = e.target.value;
    setUserId(value);

    if (value === "") {
      setFiltered(posts);
    } else {
      setFiltered(posts.filter(post => post.userId == value));
    }
  };

  return (
    <div>
      <h2 style={{ textAlign: "center", color: "white" }}>📝 Fake API Posts</h2>

      <div style={{ textAlign: "center" }}>
        <button onClick={fetchPosts}>🔄 Refresh</button>
      </div>

      <div style={{ textAlign: "center" }}>
        <select value={userId} onChange={handleFilter}>
          <option value="">All Users</option>
          <option value="1">User 1</option>
          <option value="2">User 2</option>
          <option value="3">User 3</option>
        </select>
      </div>

      {filtered.map(post => (
        <div key={post.id} className="card">
          <h4>{post.title}</h4>
          <p>{post.body}</p>
        </div>
      ))}
    </div>
  );
}

export default FakePostList;