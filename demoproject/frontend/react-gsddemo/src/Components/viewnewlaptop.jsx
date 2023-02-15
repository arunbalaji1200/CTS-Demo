import { useEffect } from "react";
import { useState } from "react";
import { Button, Container } from "react-bootstrap";
import { Navigate, useNavigate, useParams } from "react-router-dom";
import GsdService from "../Services/GsdService";

const Viewnewlaptop =()=> {
    const[newlap,setNewlap]=useState({});
    const{id}=useParams();
    const navigate=useNavigate();

    useEffect(() =>{
        const getNewlap =async(id)=>{
            const{data}=await GsdService.getNewlapid(id);
            setNewlap(data);
        }
        getNewlap(id);
    },[]);

    const Homehandler=()=>{
        navigate('/viewform');
    }
    return (  
        <Container fluid>
            <div className="row">
                <div className="card col-md-6 offset-md-3 offset md-3 mt-5 rounded shadow p-3 mb-5 bg-white">
                    
                    <div><label>ID:</label>{newlap.id}  </div>
                    <div><label>Model:</label>{newlap.model}  </div>
                    <div><label>OS:</label>{newlap.os}  </div>
                    <div><label>Ram:</label>{newlap.ramsize}  </div>
                    <div><label>capacity:</label>{newlap.capacity}  </div>
                    <div><label>Loaction to be Shipped:</label>{newlap.location}  </div>
                    <Button onClick={Homehandler}>back</Button>
                    
                 </div>
            </div>
        </Container>

    );
}

export default Viewnewlaptop;