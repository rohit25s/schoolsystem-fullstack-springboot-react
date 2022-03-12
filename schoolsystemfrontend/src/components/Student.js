import React, { useState } from 'react';
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

export default function Student({students, addStudent, onDelete}) {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[id, setId] = useState()
    const[name,setName]=useState('')
    const[email, setEmail] = useState('')
    const[schoolName,setSchoolName]=useState('')
    const[showList, setShowList] = useState(true)
    const[showForm, setShowForm] = useState(false)
    const classes = useStyles();

    const handlechangeList = () => {
        setShowList(!showList);
      };

    const handlechangeForm = () => {
        setShowForm(!showForm);
    };  

    const onSubmit = (e) => {
      e.preventDefault()
  
      if (!id) {
        alert('Please add a student')
        return
      }
  
      addStudent({ id, name, email, schoolName })
    }


    const showListResult = () => {
        return (
            <Paper elevation={3} style={paperStyle}>

            {students.map(student=>(
                <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
                Id:{student.id}<br/>
                Name:{student.name}<br/>
                Email:{student.email}<br/>
                School Name: {student.schoolName}
                <FaTimes
                style={{ color: 'red', cursor: 'pointer', float: 'right' }}
                onClick={() => onDelete(student.id)}
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
                <Button color='blue' text='Add' onClick={onSubmit}/>
            </form> 
        </Paper>
        );
    }

    return (

    <Container>
    <Button
          color={showForm ? 'red' : 'green'}
          text={showForm ? 'Close' : 'Add Student'}
          onClick={handlechangeForm}
        />
    {showForm ? showAdd() : null}    
    <br/>  
    <Button
          color={showList ? 'red' : 'green'}
          text={showList ? 'Close' : 'Show Students'}
          onClick={handlechangeList}
        />
        {showList ? showListResult() : null}    
    </Container>
    
  );
}