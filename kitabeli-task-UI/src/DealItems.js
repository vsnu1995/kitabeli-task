import React, { PureComponent } from 'react';
import axios from "axios";
import PriceCard from './PriceCard';
import { Carousel } from 'react-bootstrap';
export default class DealItems extends PureComponent {
    state = {
        items: []
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/items/deals`).then(response => {
            this.setState({ items: response.data });
        }).catch(err => {
            console.log(err);
        })
    }
    render() {
        return (
            <Carousel>{
                this.state.items.map(i => {
                    return (
                        <Carousel.Item>
                            <div className="row">
                                <div className='col-6'
                                >
                                    <img
                                        className="d-block w-100"
                                        src={i.imageUrl}
                                        alt="First slide"
                                        style={{ height: '40vh', aspectRatio: 1 }}
                                    />

                                </div>
                                <div className='col-6'>
                                    <h3>{i.name}</h3>
                                    <PriceCard variations={i.variations} discountInfo={{ discount: i.discount, expiry: i.discountExpiry }} />
                                </div>
                            </div>
                        </Carousel.Item>
                    )
                })
            }
            </Carousel>
        );
    }
}