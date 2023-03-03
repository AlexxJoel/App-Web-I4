import React from 'react'
import styled,{keyframes} from 'styled-components'

const rotate360 = keyframes`
    from{
        transform: rotate(0deg); 
    }to{
        transform: rotte(360deg); 
    }
`; 

const Spinner = styled.div`
    margin:16px; 
    animation: ${rotate360} 1s linear infinite; 
    transform: traslateZ(0); 
    border-top: 2px solid; 
    border-right: 2px solid grey; 
    border-left: 4px solid grey; 
    border-bottom: 2px solid grey; 
    background: transparent; 
    width: 80px; 
    height: 80px; 
    border-radius: 50%; 
`; 

export const Loading = () => {
  return (
    <div style={{padding: '24px'}}><Spinner/></div>
  )
}
