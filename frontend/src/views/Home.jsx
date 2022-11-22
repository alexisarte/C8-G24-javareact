import { Link } from 'react-router-dom';
import { SlideBar } from './SlideBar';
import NavBar from './NavBar';
import Services from './Services';

const Home = () => {
  return (
    <>
      <NavBar />
      <SlideBar />
      <Services />
    </>
  );
};

export default Home;
