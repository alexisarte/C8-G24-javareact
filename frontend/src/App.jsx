import { useState, useEffect } from "react";
import Home from "./views/Home";
import { Routes, Route } from "react-router-dom";

import YellowTop from "./views/YellowBar/YellowTop";
import { Onboarding } from "./views/Onboarding/Onboarding";
import Products from "./views/navBar/Products";
import Footers from "./views/Footer/Footer";

function App() {
  const [load, setLoad] = useState(true);
  useEffect(() => {
    setTimeout(() => {
      setLoad(false);
    }, 3550);
  }, []);

  // if (load) {
  //   return(
  //     <Onboarding/>
  //   )
  // } else {
    return (
      <div className="Container">
        <YellowTop />
        <Routes>
          <Route path="/" element={<Home />} />
          {/* <Route path="/login" element={<Login />} /> */}
          <Route path="/dogs/:product" element={<Products />}></Route>
          <Route path="/cats/:product" element={<Products />}></Route>
          <Route path="/others/:product" element={<Products />}></Route>
          <Route path="/promotions/:product" element={<Products />}></Route>
          <Route path="/services/:product" element={<Products />}></Route>
        </Routes>
        <Footers />
      </div>
    );
  }
// }

export default App;
