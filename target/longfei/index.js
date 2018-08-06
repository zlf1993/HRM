import React from "react";
import ReactDOM from "react-dom";

class Computer extends React.Component {
  constructor() {
      super();
      this.state = {
	  status: 'off',
	  showContent: '显示器关了'
      }
  }
  handleTagger() {
    let sta;
  	let content;
  	if(this.state.status == 'on') {
  		sta = 'off'; 
  		content = '显示器关了';
  	}
  	else {
  		sta = 'on'; 
  		content = '显示器亮了';
  	} 
    this.setState({
      status: sta,
      showContent: content
    })
  }
  render () {
    return (
      <div>
      <p>haha1111</p>
      <p>这个局部热新</p>
        <button onClick={() => this.handleTagger()}>开关1</button>
        <Screen showContent={this.state.showContent} />
      </div>
    )
  }
}

class Screen extends React.Component {
  getDefaultProps(){
    return {
      name: 'demo'
    };
  }
  render () {
    const showContent = this.props.showContent;
    return (
      <div className='screen'>
        {showContent}
      </div>
    )
  }
}

ReactDOM.render(<Computer/>,document.getElementById("root"));;