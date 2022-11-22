import { useState , useEffect } from 'react';
import Home from './views/Home';
import { Routes, Route } from 'react-router-dom';
import YellowTop from "./views/YellowTop";
import { Onboarding } from './views/Onboarding';

function App() {
  const [load, setLoad] = useState(true)
   useEffect (() => {
        setTimeout(() => {
            setLoad(false);
        }, 3550)        
        
    }, [])   

  if(load){
    return(
      <Onboarding/>
    )
  }else{

  return (
    <div className="Container">
     <YellowTop/>
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes> 
      
    </div>
  );
    }
}

export default App;