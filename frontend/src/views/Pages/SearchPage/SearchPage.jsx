import { useContext, useEffect } from "react";
import SearchContext from "../../Context/SearchContext/SearchContext";
import products from '../../Records/ProductsLists/ProductLists.json'


const SearchPage = () =>{
    const {search} = useContext(SearchContext)
    // useEffect(() => {
    //     if(search === )
    //    }, []);
     
    return(
        <>
        <div>
            
            {/* {search ===  ? "": "" } */}
        </div>
        </>
    )
}

export default SearchPage