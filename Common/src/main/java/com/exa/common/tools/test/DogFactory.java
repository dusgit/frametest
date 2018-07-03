package com.exa.common.tools.test;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class DogFactory implements PooledObjectFactory<Dog> {

	@Override
	public void activateObject(PooledObject<Dog> arg0) throws Exception {
		arg0.getObject().setActive(true);
	}

	@Override
	public void destroyObject(PooledObject<Dog> arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("销毁对象");
	}

	@Override
	public PooledObject<Dog> makeObject() throws Exception {
		Dog dog = new Dog();
		return new DefaultPooledObject<Dog>(dog);
	}

	@Override
	public void passivateObject(PooledObject<Dog> arg0) throws Exception {
		// TODO Auto-generated method stub
		// 重置对象
	}

	@Override
	public boolean validateObject(PooledObject<Dog> arg0) {
		if(arg0.getObject().isActive()){
			return true;
		}else{
			return false;
		}
	}

}
