import FeatherIcon from 'feather-icons-react/build/FeatherIcon'
import React from 'react'
import { Button } from 'react-bootstrap'


export const ButtonCircle = ({type , onClick, icon = "", size = 15 }) => {
  return (
    <Button className={type} onClick={onClick}>
        { icon  && ( <FeatherIcon icon={icon} size={size} style={{strokWidth: 2.5 }} /> )}
    </Button>
  )
}
