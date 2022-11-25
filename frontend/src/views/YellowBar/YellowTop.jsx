import React from 'react'

//Images and vectors
import image from '../../assets/img-kai_pet.png'

import hearth from '../../assets/vectors/hearth.svg'
import whatsapp from '../../assets/vectors/whatsapp.svg'

import user from '../../assets/vectors/user.svg'



//Components
import Location from './Location'
import SearchInput from './SearchInput'
import SocialNetworks from './SocialNetworks'
import { useState } from 'react'
import Account from './Account'
import Cart from './Cart'
import Favourites from './Favourites'

function YellowTop() {
    
   

  return (
    <div className='bg-[#F8CF32] pt-2'>
        <div className='flex flex-row justify-between mx-48 items-center max-lg:mx-24 max-sm:mx-8 max-lg:flex-wrap max-sm:justify-center' id='zindexFixFirst'>  
            <Location/>   
            <div className='flex flex-row items-center gap-3 font-fontGafata'>
                <SocialNetworks/>
            </div>      
          <Account/>
        </div>
        <div className='flex flex-row justify-between mx-48 items-center max-lg:flex-wrap max-lg:mx-24 max-sm:mx-8 max-lg:justify-center' id='zindex'>
            <a href='' className='flex flex-row'>
                <img src={image} className="w-32" alt='img-kaipet'></img>
                <div className='flex flex-col justify-end mb-2 text-white font-logoFont gap-2 mr-44 max-lg:mr-0'>
                    <p className='text-4xl'>KAI</p>
                    <p className='text-4xl'>PET</p>
                </div>
            </a>
            <SearchInput/>
            <div className='flex gap-4 mt-3 mb-3'>
                <div className='flex flex-row items-center font-fontGafata gap-2'>
                   <Favourites/>
                    <Cart/>
                </div>
            </div>
        </div>
    </div>
  )
}

export default YellowTop