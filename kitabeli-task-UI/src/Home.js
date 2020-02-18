import React, {PureComponent} from 'react';
import axios from "axios";
import { NavLink } from 'react-router-dom'
import {Card} from 'react-bootstrap';
export default class Home extends PureComponent{
    state = {
        categories: []
    }

    componentDidMount(){
        axios.get(`http://localhost:8080/categories/all`).then(response => {
            this.setState({categories: response.data});
        }).catch(err => {
            console.log(err);
        })
    }
    render(){
        return (
            this.state.categories.map(c => {
                return (
                <Card style={{ width: '18rem',height: '18rem', float: "left", margin: '1rem' }}>
                <Card.Img variant="top" src={c.imageUrl} />
                <Card.Body>
                  <Card.Title>{c.name}</Card.Title>
                  <NavLink to={`/items/${c.id}`}>Go</NavLink>
                </Card.Body>
              </Card>)
            })
        );
    }
}