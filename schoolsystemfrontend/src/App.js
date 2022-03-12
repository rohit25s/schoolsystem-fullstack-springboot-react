import './App.css';
import Appbar from './components/Appbar'
import User from './components/User'

function App() {

  const deleteProfessor = async (id) => {
    console.log('delete professor with Id:'+ id);
    // const res = await fetch(`http://localhost:5000/tasks/${id}`, {
    //   method: 'DELETE',
    // })
    // //We should control the response status to decide if we will change the state or not.
    // res.status === 200
    //   ? setTasks(tasks.filter((task) => task.id !== id))
    //   : alert('Error Deleting This Task')
  }

  const deleteStudent = async (id) => {
    console.log('delete student with Id:'+ id);
    // const res = await fetch(`http://localhost:5000/tasks/${id}`, {
    //   method: 'DELETE',
    // })
    // //We should control the response status to decide if we will change the state or not.
    // res.status === 200
    //   ? setTasks(tasks.filter((task) => task.id !== id))
    //   : alert('Error Deleting This Task')
  }

  return (
    <div className="App">
    <Appbar/>
    <User onDeleteProfessor={deleteProfessor} onDeleteStudent={deleteStudent}/>
    </div>
  );
}

export default App;