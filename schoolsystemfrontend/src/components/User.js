import React, {useState, useCallback } from 'react';
import {Container} from '@material-ui/core';
import Student from './Student'
import Professor from './Professor';
import Button from './Button'

export default function User({onDeleteProfessor, onDeleteStudent}) {
  const [value, setValue] = useState(true);

  const toggle = useCallback(() => {
    setValue(v => !v);
  }, []);
  return (

    <Container>
    Click button to toggle user type:    
    <Button
          color={value ? 'blue' : 'green'}
          text={value ? 'Student' : 'Professor'}
          onClick={toggle}
        />
    {value ? <Student onDelete={onDeleteStudent}/> : <Professor onDelete={onDeleteProfessor}/>}    

    </Container>
  );
}