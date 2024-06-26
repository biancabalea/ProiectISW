import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {
  const [user, setUser] = useState({
    name: "",
    department: "",
    email: "",
    post: "",
    phone: "",
    leaveDays: "",
  });

  const { id } = useParams();

  useEffect(() => {
    const loadUser = async () => {
      const result = await axios.get(`http://localhost:8080/user/${id}`);
      setUser(result.data);
    };

    loadUser();

  }, [id]);

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Employee Details</h2>

          <div className="card">
            <div className="card-header">
              Details of employee id : {user.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Name: </b>
                  {user.name}
                </li>
                <li className="list-group-item">
                  <b>Department: </b>
                  {user.department}
                </li>
                <li className="list-group-item">
                  <b>Post: </b>
                  {user.post}
                </li>
                <li className="list-group-item">
                  <b>Email: </b>
                  {user.email}
                </li>
                <li className="list-group-item">
                  <b>Phone: </b>
                  {user.phone}
                </li>
                <li className="list-group-item">
                  <b>Leave Days: </b>
                  {user.leaveDays}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-secondary my-2" to={"/"}>
            Back to Home
          </Link>
        </div>
      </div>
    </div>
  );
}
