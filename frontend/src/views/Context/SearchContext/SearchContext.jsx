import { createContext ,useState } from "react";

import { useNavigate } from "react-router-dom";

const SearchContext = createContext();

const SearchProvider = ({ children }) => {

    let navigate = useNavigate();

    const [search, setSearch] = useState();
  
    const handleSearch = (e) =>{
        navigate('/search')
        setSearch(e.target.value);
    }
  
    const data = {
        handleSearch,
        search
    };

    return(
        <SearchContext.Provider value={data}> 
        {children} 
        </SearchContext.Provider>
    )
}

export default SearchContext;

export {SearchProvider};