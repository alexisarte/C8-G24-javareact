import { useState } from "react";
import Login from "./views/Login";
import ProductsList from "./views/ProductsLists";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="Container">
      <Login />
      <ProductsList />
    </div>
  );
}

export default App;
