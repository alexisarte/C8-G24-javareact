import { createContext ,useState } from "react";

import { useNavigate } from "react-router-dom";

import products from '../../Records/ProductsLists/ProductLists.json'

const SearchContext = createContext();

const SearchProvider = ({ children }) => {

    let navigate = useNavigate();

    const [search, setSearch] = useState();
    const [match , setMatch] = useState([]);
  
    const handleSearch = (e) =>{
        navigate('/search')
        setSearch(e.target.value);

        let searchKeywords = e.target.value; 

        const matchProductsKeywords = products.filter((item) => item.product.toUpperCase().includes(searchKeywords.toUpperCase()))
        setMatch(matchProductsKeywords)
        // for (let i = 0; i < products.length; i++) {
        //     console.log(products[i].product)
        // }


    }
  
    const data = {
        handleSearch,
        search,
        match
    };

    return(
        <SearchContext.Provider value={data}> 
        {children} 
        </SearchContext.Provider>
    )
}

export default SearchContext;

export {SearchProvider};