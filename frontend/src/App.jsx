import { useState , useEffect } from 'react';
import Home from './views/Home';
import { Routes, Route } from 'react-router-dom';

import YellowTop from './views/YellowBar/YellowTop';
import { Onboarding } from './views/Onboarding/Onboarding';
import Dogs from './views/navBar/Products';
import Footers from './views/Footer/Footer';

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
      <YellowTop />
      <Routes>
        <Route path="/" element={<Home />} />
        {/* <Route path="/login" element={<Login />} /> */}
        <Route path="/dogs/:product" element={<Dogs />}></Route>
        <Route path="/cats/:product" element={<Dogs />}></Route>
        <Route path="/others/:product" element={<Dogs />}></Route>
        <Route path="/promotions/:product" element={<Dogs />}></Route>
        <Route path="/services/:product" element={<Dogs />}></Route>
      </Routes>
      <Footers/>
    </div>
  );
    }
}

export default App;