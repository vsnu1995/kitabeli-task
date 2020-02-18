import React from 'react';
import { Dropdown } from 'react-bootstrap'
export default class PriceCard extends React.PureComponent {
    constructor(props) {
        super(props);
        this.state = {
            selectedVariant: props.variations[0],
            selectedType: 1
        }
    }

    changeVariant = (selectedVariant, selectedType) => {
        this.setState({ selectedVariant, selectedType })
    }

    render() {

        const selectedVariant = this.state.selectedVariant, {discountInfo: {discount, expiry} }=  this.props;
        const validDiscount = discount && new Date(expiry) > Date.now();
        const discountedPrice = validDiscount ? (selectedVariant.price * (100 - discount)) / 100: selectedVariant.price;
        return (
            <div>

                <Dropdown>
                    <Dropdown.Toggle variant="info" id="dropdown-basic" size="sm">
                        Type {this.state.selectedType}
                    </Dropdown.Toggle>

                    <Dropdown.Menu>{
                        this.props.variations.map((v, i) => {
                            return (
                                <Dropdown.Item onClick={() => this.changeVariant(v, i + 1)}>
                                    Type {i + 1}
                                </Dropdown.Item>
                            );
                        })
                    }
                    </Dropdown.Menu>
                </Dropdown>
                <br/>
                Details:
                <ul>
                    {Object.keys(selectedVariant.variations).map(
                        x => {
                            return <li> {x} : {selectedVariant.variations[x]} </li>
                        }
                    )}
                </ul>

                    Price: <span style={discount && new Date(expiry) > Date.now() ? { textDecoration: 'line-through'}: {}}>{selectedVariant.price} </span>
                    {validDiscount ? <h4 style={{textAlign: 'center'}}>{discountedPrice}</h4> : null}
            </div>
        );

    }
}