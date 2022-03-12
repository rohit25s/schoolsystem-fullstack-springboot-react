import './App.css';
import React, { useEffect, useState } from 'react';
import Appbar from './components/Appbar'
import User from './components/User'

function App() {
  const[professors, setProfessors]=useState([])
  const[students, setStudents]=useState([])

  const deleteProfessor = async (id) => {
    console.log('delete professor with Id:'+ id);
    const res = await fetch(`http://localhost:8080/professor/${id}`, {
    method: 'DELETE',
    })
    console.log(res);
    setProfessors(professors.filter((professor) => professor.id !== id))
  }

  const deleteStudent = async (id) => {
    console.log('delete student with Id:'+ id);
    const res = await fetch(`http://localhost:8080/student/${id}`, {
      method: 'DELETE',
      })
      console.log(res)
      setStudents(students.filter((student) => student.id !== id))
  }

  const addProfessor= async (professor)=>{
      console.log(professor)
      const res = await fetch("http://localhost:8080/professor",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(professor)
    })
    if (res.status >= 400 && res.status < 600) {
      alert("Professor with id already present!");
    }
    else{
      const data = await res.json();
      console.log(data);

      setProfessors([...professors, data]);
    }
  }

  const addStudent= async (student)=>{
    console.log(student)
    const res = await fetch("http://localhost:8080/student",{
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(student)
  })
  if (res.status >= 400 && res.status < 600) {
    alert("Student with id already present!");
  }
  else{
    const data = await res.json();
    console.log(data);

    setStudents([...students, data]);
  }
}

  useEffect(()=>{
    fetch("http://localhost:8080/student/")
    .then(res=>res.json())
    .then((result)=>{
        setStudents(result);
        })
    },[])

  useEffect(()=>{
      fetch("http://localhost:8080/professor/")
      .then(res=>res.json())
      .then((result)=>{
          setProfessors(result);
          })
      },[])  

  return (
    <div className="App">
    <Appbar/>
    <User
    students = {students}
    professors = {professors}
    addStudent = {addStudent} 
    addProfessor = {addProfessor} 
    onDeleteProfessor={deleteProfessor} 
    onDeleteStudent={deleteStudent}/>
    </div>
  );
}

export default App;