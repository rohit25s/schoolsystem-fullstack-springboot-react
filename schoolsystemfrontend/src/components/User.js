import React, {useState, useCallback } from 'react';
import {Container} from '@material-ui/core';
import Student from './Student'
import Professor from './Professor';
import Button from './Button'

export default function User({students, professors, addStudent, addProfessor, onDeleteProfessor, onDeleteStudent}) {
  const [value, setValue] = useState(true);

  const toggle = useCallback(() => {
    setValue(v => !v);
  }, []);
  return (

    <Container>
    Click button to toggle user type:    
    <Button
          color={value ? 'blue' : 'green'}
          text={'Toggle'}
          onClick={toggle}
        /><br/>
    <h1>{value ? 'Students' : 'Professor'} </h1>    
    {value ? 
    <Student 
        students = {students}
        addStudent = {addStudent}
        onDelete={onDeleteStudent}
    /> : 
    <Professor 
        professors = {professors}
        addProfessor ={addProfessor}
        onDelete={onDeleteProfessor}
    />}    

    </Container>
  );
}