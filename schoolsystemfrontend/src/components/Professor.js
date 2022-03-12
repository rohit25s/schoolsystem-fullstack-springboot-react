import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper} from '@material-ui/core';
import { FaTimes } from 'react-icons/fa';
import Button from './Button'

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function Professor({onDelete}) {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[id, setId] = useState()
    const[name,setName]=useState('')
    const[email, setEmail] = useState('')
    const[schoolName,setSchoolName]=useState('')
    const[courseTaught, setCourseTaught] = useState('')
    const[professors,setProfessors]=useState([])
    const[showList, setShowList] = useState(true)
    const[showForm, setShowForm] = useState(false)
    const classes = useStyles();
    

  const handleClick=(e)=>{
        e.preventDefault()
        const professor={id, name, email, schoolName, courseTaught}
        console.log(professor)
        fetch("http://localhost:8080/professor",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(professor)
        }).then(()=>{
            console.log("New Professor added")
        })
    }

    const handlechangeList = () => {
        setShowList(!showList);
      };

    const handlechangeForm = () => {
        setShowForm(!showForm);
    };  

    useEffect(()=>{
    fetch("http://localhost:8080/professor/")
    .then(res=>res.json())
    .then((result)=>{
        setProfessors(result);
        })
    },[])

    const showListResult = () => {
        return (
            <Paper elevation={3} style={paperStyle}>

            {professors.map(professor => (
                <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={professor.id}>
                Id:{professor.id}<br/>
                Name:{professor.name}<br/>
                Email:{professor.email}<br/>
                School Name: {professor.schoolName}<br/>
                Course Taught: {professor.courseTaught}
                <FaTimes
                style={{ color: 'red', cursor: 'pointer', float: 'right' }}
                onClick={() => onDelete(professor.id)}
                />
                </Paper>
            ))  
        }
        </Paper>
        );
    }

    const showAdd = () => {
        return (
            <Paper elevation={3} style={paperStyle}>
 
            <form className={classes.root} noValidate autoComplete="off">
                <TextField id="outlined-basic" label="Id" variant="outlined" fullWidth 
                value={id}
                onChange={(e)=>setId(e.target.value)}
                />  
                <TextField id="outlined-basic" label="Name" variant="outlined" fullWidth 
                value={name}
                onChange={(e)=>setName(e.target.value)}
                />
                <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth
                value={email}
                onChange={(e)=>setEmail(e.target.value)}
                />
                <TextField id="outlined-basic" label="School Name" variant="outlined" fullWidth
                value={schoolName}
                onChange={(e)=>setSchoolName(e.target.value)}
                />
                 <TextField id="outlined-basic" label="Course Taught" variant="outlined" fullWidth
                value={courseTaught}
                onChange={(e)=>setCourseTaught(e.target.value)}
                />
                <Button color='blue' text='Add' onClick={handleClick}/>
            </form> 
        </Paper>
        );
    }

    return (

    <Container>
    <Button
          color={showForm ? 'red' : 'green'}
          text={showForm ? 'Close' : 'Add Professor'}
          onClick={handlechangeForm}
        />
    {showForm ? showAdd() : null}    

    <Button
          color={showList ? 'red' : 'green'}
          text={showList ? 'Close' : 'Show Professors'}
          onClick={handlechangeList}
        />
        {showList ? showListResult() : null}    
    </Container>
  );
}