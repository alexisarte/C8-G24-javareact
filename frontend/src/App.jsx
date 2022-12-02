import { useState, useEffect } from "react";
import Home from "./views/Pages/Home/Home";
import { Routes, Route } from "react-router-dom";

import YellowTop from "./views/YellowBar/YellowTop";
import { Onboarding } from "./views/Onboarding/Onboarding";
import Products from "./views/Pages/Categories/Products";
import Footers from "./views/Footer/Footer";
import NavBar from "./views/navBar/NavBar";
import SearchPage from "./views/Pages/SearchPage/SearchPage";

import { SearchProvider } from "./views/Context/SearchContext/SearchContext";
import { CartPage } from "./views/Pages/CartPage/CartPage";

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
        <SearchProvider>
        <YellowTop />
        <NavBar/>
        <Routes>
          <Route path="/" element={<Home />} />
          {/* <Route path="/login" element={<Login />} /> */}
          <Route path="/dogs/:product" element={<Products />}></Route>
          <Route path="/cats/:product" element={<Products />}></Route>
          <Route path="/others/:product" element={<Products />}></Route>
          <Route path="/promotions/:product" element={<Products />}></Route>
          <Route path="/services/:product" element={<Products />}></Route>
          <Route path="/search" element = {<SearchPage/>}></Route>
          <Route path="/cart" element = {<CartPage/>} ></Route>
        </Routes>
        <Footers />
        </SearchProvider>
      </div>
    );
  }
// }

export default App;
