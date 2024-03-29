import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddUser() {
  let navigate = useNavigate();

  const [user, setUser] = useState({
    name: "",
    department: "",
    email: "",
    post: ""
  });

  const { name, department, email, post } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/user", user);
    navigate("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register Employee</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter the name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Department" className="form-label">
                Department
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter the department"
                name="department"
                value={department}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Post" className="form-label">
                Post
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter the post"
                name="post"
                value={post}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                E-mail
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter the e-mail address"
                name="email"
                value={email}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-secondary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/home">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}