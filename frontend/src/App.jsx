import { useState } from 'react';
import Login from './views/Login';
import Home from './views/Home';
import Dogs from './views/Dogs';

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="Container">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/dogs/:product" element={<Dogs />}>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
