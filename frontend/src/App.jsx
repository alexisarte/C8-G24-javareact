import { useState } from "react";
import Login from "./views/Login";
import ProductsList from "./views/ProductsLists";
import { SlideBar } from "./views/SlideBar";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="Container">
      <Login />
      <ProductsList />
      <SlideBar />
    </div>
  );
}

export default App;
