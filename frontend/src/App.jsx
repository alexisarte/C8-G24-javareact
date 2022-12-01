import { useState, useEffect } from "react";
import Home from "./views/Pages/Home/Home";
import { Routes, Route } from "react-router-dom";

import YellowTop from "./views/YellowBar/YellowTop";
import { Onboarding } from "./views/Onboarding/Onboarding";
import Products from "./views/Pages/Categories/Products";
import Footers from "./views/Footer/Footer";
import NavBar from "./views/navBar/NavBar";
import SearchPage from "./views/Pages/SearchPage/SearchPage";
import Product from "./views/catalog/catalog";

import { SearchProvider } from "./views/Context/SearchContext/SearchContext";

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
        <Route
          path="/perros/:product"
          element={<Products name="perros" />}
        ></Route>
        <Route
          path="/gatos/:product"
          element={<Products name="gatos" />}
        ></Route>
        <Route
          path="/otros/:product"
          element={<Products name="otros" />}
        ></Route>
        <Route
          path="/promociones/:product"
          element={<Products name="promociones" />}
        ></Route>
        <Route
          path="/servicios/:product"
          element={<Products name="servicios" />}
        ></Route>
        <Route path="/search" element={<SearchPage />}></Route>
        <Route path="/producto" element={<Product />}></Route>
      </Routes>
        <Footers />
        </SearchProvider>
      </div>
    );
  }
// }

export default App;
