import { Link } from 'react-router-dom';
import { SlideBar } from './SlideBar';
import NavBar from './NavBar';
import Services from './Services';

const Home = () => {
  return (
    <>
      <button className="bg-red-200 p-5">
        <Link to="/login">Login</Link>
      </button>
      <NavBar />
      <SlideBar />
      <Services />
    </>
  );
};

export default Home;
