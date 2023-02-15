import axios from "axios";

class GsdService{
    getRole(){
        return axios.get('http://localhost:8080/getrole');
    }
    getUser(){
        return axios.get('http://localhost:8080/getuser');
    }
    getRoleId(id){
        // console.log("Roleservice");
        // console.log(id);
        return axios.get('http://localhost:8080/getidrole/'+id);
    }
    addRole(id,user){
        console.log("serviceclass");
        console.log(user);
        return axios.post('http://localhost:8080/adduser/'+id,user);
    }
    getUserId(id){
        console.log("UserService");
        console.log(id);
        return axios.get('http://localhost:8080/getiduser/'+id);
    }
    updateUser(id,data){
        console.log(data);
        return axios.patch('http://localhost:8080/updateuser/'+id,data);
    }
    deleteUsers(id){
        return axios.delete('http://localhost:8080/deleteuser/'+id)
    }
    saveForm(newlap){
        return axios.post('http://localhost:8080/saveform',newlap);
    }
    getForm(page,size){
        console.log(page,size);
        return axios.get('http://localhost:8080/getform?pageNo='+page+'&pageSize='+size);
    }
    getNewlap(){
        return axios.get('http://localhost:8080/getnewlap');
    }
    getNewlapid(id){
        console.log(id);
        return axios.get('http://localhost:8080/getnewid/'+id);
    }
    getRepairlapid(id){
        return axios.get('http://localhost:8080/getrepairid/'+id);
    }
    saveStatus(id,status){
        console.log(id);
        console.log(status);
        return axios.post('http://localhost:8080/update/status/'+id,status,
        {
            headers: {
                'Content-Type': 'application/json',
            }
        }
        );
    }
    saveComment(id,comment){
        console.log(comment);
        return axios.post('http://localhost:8080/update/comment/'+id,comment,
        {
            headers: {
                'Content-Type': 'application/json',
            }
        }
        );
    }
}
export default new GsdService()