import { useState } from "react";
import Login from "./views/Login";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="Container">
      <Login />
    </div>
  );
}

export default App;
