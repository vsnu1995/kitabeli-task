import React, {PureComponent} from 'react';
import axios from "axios";
import {Card} from 'react-bootstrap';
import {withRouter} from 'react-router';
import PriceCard from './PriceCard';
class Items extends PureComponent{
    state = {
        items: []
    }

    componentDidMount(){

        let id = this.props.match.params.id
        axios.get(`http://localhost:8080/items/${id}`).then(response => {
            this.setState({items: response.data});
        }).catch(err => {
            console.log(err);
        })
    }
    render(){
        return (
            this.state.items.map(c => {
                return (
                <Card style={{ width: '18rem',height: '35rem', float: "left", margin: '1rem' }}>
                <Card.Img variant="top" src={c.imageUrl} style={{maxHeight: '10rem'}} />
                <Card.Body>
                  <Card.Title>{c.name}</Card.Title>
                  <Card.Text>{c.description}</Card.Text>
                    <Card.Footer><PriceCard variations={c.variations} discountInfo={{discount: c.discount, expiry: c.discountExpiry}}/></Card.Footer>
                </Card.Body>
              </Card>)
            })
        );
    }
}

export default withRouter(Items) ;