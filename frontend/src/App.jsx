import { useState } from "react";
import Login from "./views/Login";
import ProductsList from "./views/ProductsLists";
import { SlideBar } from "./views/SlideBar";
import NavBar from './views/NavBar';

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="Container">
      <Login />
      <NavBar />
      <SlideBar />
      <ProductsList />
    </div>
  );
}

export default App;
