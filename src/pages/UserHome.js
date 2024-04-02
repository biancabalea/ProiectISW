import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const UserHome = () => {
  const [users, setUsers] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    try {
      const result = await axios.get("http://localhost:8080/users");
      setUsers(result.data);
    } catch (error) {
      console.error("Error loading users:", error);
    }
  };

  const sortByName = () => {
    const sortedUsers = [...users].sort((a, b) => a.name.localeCompare(b.name));
    setUsers(sortedUsers);
  };

  const requestLeave = async (userId, leaveDays) => {
    try {
      const response = await axios.post(`http://localhost:8080/requestLeave/${userId}?leaveDays=${leaveDays}`);
      loadUsers();
    } catch (error) {
      console.error("Error requesting leave:", error);
    }
  };

  const showLeaveRequestForm = (userId) => {
    const leaveDays = prompt("Enter number of leave days:");
    if (leaveDays !== null) {
      const numericLeaveDays = parseInt(leaveDays);
      const user = users.find(user => user.id === userId);
      if (numericLeaveDays <= user.leaveDays) {
        requestLeave(userId, numericLeaveDays);
      } else {
        setError("Error: Number of leave days exceeds remaining leave days.");
      }
    }
  };

  const closeError = () => {
    setError("");
  };

  return (
    <div className="container">
      <button onClick={sortByName}>Sort by Name</button>
      {error && (
        <div className="alert alert-danger">
          {error}
          <button className="btn-close" onClick={closeError}></button>
        </div>
      )}
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Name</th>
              <th scope="col">Department</th>
              <th scope="col">Post</th>
              <th scope="col">Email</th>
              <th scope="col">Phone</th>
              <th scope="col">Leave Days</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user, index) => (
              <tr key={index}>
                <th scope="row">{index + 1}</th>
                <td>{user.name}</td>
                <td>{user.department}</td>
                <td>{user.post}</td>
                <td>{user.email}</td>
                <td>{user.phone}</td>
                <td>{user.leaveDays}</td>
                <td>
                  <button className="btn btn-outline-secondary mx-2" onClick={() => showLeaveRequestForm(user.id)}>Request Leave</button>
                  <Link
                    className="btn btn-secondary mx-2"
                    to={`/viewuser/${user.id}`}
                  >
                    View
                  </Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UserHome;
