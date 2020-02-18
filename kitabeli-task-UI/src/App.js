import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import Home from './Home';
import Items from './Items';
import DealItems from './DealItems';
export default function App() {
  return (
    <Router>
      <div className='App'>
      <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/deals">Daily deals</Link>
          </li>
        </ul>
        <Switch>
          <Route exact path="/">
            <Home/>
          </Route>
          <Route path="/items/:id">
            <Items/>
          </Route>
          <Route path="/deals">
            <DealItems />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}
