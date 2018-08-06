import React from "react";
import ReactDOM from "react-dom";
import {Form,FormGroup,Col,FormControl,Checkbox,ControlLabel,Button} from 'react-bootstrap/lib'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/css/bootstrap.min.css';

const wellStyles = {maxWidth:400, margin:'0 auto 10px'}
class Computer extends React.Component {
  constructor() {
      super();
      this.state = {
        username: '',
        password: ''
      }
  }
  render () {
    return (
      <div>
        <Form horizontal action="">
          <FormGroup controlId="formHorizontalUsername">
            <Col ComponentClass={ControlLabel} sm={2}>
              UserName
            </Col>
            <Col sm={6}>
              <FormControl type="text" placeholder="帐户名"/>
            </Col>
          </FormGroup>

          <FormGroup controlId="formHorizintalPassword">
            <Col ComponentClass={ControlLabel} sm={2}>
              Password
            </Col>
            <Col sm={6}>
              <FormControl type="password" placeholder="密码"/>
            </Col>
          </FormGroup>

          <FormGroup>
            <Col smOffset={2} sm={6}>
              <Checkbox>记住我</Checkbox>
            </Col>
          </FormGroup>

          <FormGroup>
            <Col smOffset={2} sm={6}>
              <Button type="submit">
                Login
              </Button>
            </Col>
          </FormGroup>
        </Form>
      </div>
    )
  }
}

ReactDOM.render(<Computer/>,document.getElementById("root"));;